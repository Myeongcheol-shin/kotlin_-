class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
    var answer = mutableListOf<Int>()
    // 차량 번호와 누적 주차 시간 계산기
    // 주차 정보는 key, value 형태로 저장 key -> 차량 번호 value -> Pair구조 [누적 주차시간, 주차 시작 시작 시간(분으로 저장) 없으면 -1]
    var parking_arr : MutableMap<String, Pair<Int, Int>> = mutableMapOf()
    // 23:59분을 분단위로 변경
    val midnight = 23 * 60 + 59
    // 기록을 순회하면서 데이터를 저장
    records.forEach { r ->
        val record = r.split(" ")
        val time = record[0].split(":").map{it.toInt()}
        val minute = time[0] * 60 + time[1]
        val car_number = record[1]

        // 차량이 들어온 경우 IN
        if(record[2] == "IN") {
            // (1) 이미 한번 들어왔던 경우
            val find = parking_arr[car_number]
            if(find != null) {
                val v = find.first
                parking_arr[car_number] = Pair(v, minute)
            }
            // (2) 처음 들어오는 경우
            else {
                parking_arr[car_number] = Pair(0, minute)
            }
        }
        // 차량이 나가는 경우
        else {
            // 무조건 차량은 등록되어 있음
            val find = parking_arr[car_number]
            // 출차 시간 - 입차 시간 계산
            val use_minute = minute - find!!.second
            // 기존의 값에 갱신
            parking_arr[car_number] = Pair(find.first + use_minute, -1)
        }
    }
    // 주차 시간을 모두 계산
    // 아직 출차가 안된 항목을 탐색
    parking_arr.forEach { (key, value) ->
        // 아직 출차가 안된 항목
        if(value.second != -1) {
            // 23:59분을 출차로 설정
            var t = midnight - value.second
            // 기존 항목 최신화
            parking_arr[key] = Pair(value.first + t, -1)
        }
        // 점수 비용 계산
        val cf = calFees(key, parking_arr[key]!!, fees)
        parking_arr[key] = Pair(cf, -1)
    }

    var sortedMap = parking_arr.toList().sortedWith(compareBy({it.first})).toMap()
    sortedMap.forEach{ (key, value) ->
        answer.add(value.first)
    }


    return answer.toIntArray()
}

// 추가 요금 계산 함수 인자로 초과된 시간 만큼 들어옴
private fun calFees(key: String, value :  Pair<Int, Int>, fees : IntArray) : Int {
    // 초과하는 지 체크
    // (1) 초과하지 않음
    if(fees[0] >= value.first) {
        return fees[1]
    }
    // (2) 초과
    else{
        val c = value.first - fees[0]
        if(c % fees[2] == 0) return fees[1] + (c / fees[2]) * fees[3]  else return fees[1] + ((c / fees[2]) + 1) * fees[3]
    }
}

}