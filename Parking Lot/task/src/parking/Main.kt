package parking

fun main() {
    var parking: MutableList<Boolean> = mutableListOf()
    var cars: MutableList<String> = mutableListOf()

    while (true) {
        var data = readln().split(" ")

        if (data.contains("create")) {

            parking.clear()
            parking = MutableList(data[1].toInt()) { true }
            cars = MutableList(data[1].toInt()) { "" }
            println("Created a parking lot with ${data[1]} spots.")
        } else if (data.contains("status") && parking.all { it.equals(true) } && parking.size > 0) {

            println("Parking lot is empty.")
        } else if (data.contains("park") && parking.any { it.equals(true) }) {
            println("${data[2]} car parked in spot ${parking.indexOf(true) + 1}.")
            var l = parking.indexOf(true)
            parking[parking.indexOf(true)] = false

            cars[l] = "${l + 1} ${data[1]} ${data[2]}"
        } else if (data.contains("status") && parking.any { it.equals(false) }) {
            for (i in cars) {
                if (i.isNotBlank()) {
                    println("$i")
                }
            }
        } else if (data.contains("leave") && parking.any { it.equals(false) }) {

            if (!parking[data[1].toInt() - 1]) {


                println("Spot ${data[1]} is free.")
                parking[data[1].toInt() - 1] = true
                cars[data[1].toInt() - 1] = ""


            }
        } else if (data.contains("exit")) {
            break
        } else if (parking.all { it.equals(false) } && parking.size > 0) {
            println("Sorry, the parking lot is full.")
        } else {
            println("Sorry, a parking lot has not been created.")
        }

    }
}






//    while (true) {
//
//        var data = readln().split(" ")
//        if (data.contains("park")) {
//            if (spots.any { it.equals(true) }) {
//                println("${data[2]} car parked in spot ${spots.indexOf(true) + 1}.")
//                spots[spots.indexOf(true)] = false
//
//            }
//        } else if (data.contains("leave")) {
//
//            if (!spots[data[1].toInt() - 1]) {
//
//                println("Spot ${data[1]} is free.")
//                spots[data[1].toInt() - 1] = true
//
//            }
//        } else if (data.contains("exit")) {
//            break
//        }
//
//
//
//    }

//}
