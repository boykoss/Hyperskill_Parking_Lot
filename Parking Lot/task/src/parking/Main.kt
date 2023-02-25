package parking

fun main() {
    var spots = MutableList(20) { true }



    while (true) {

        var data = readln().split(" ")
        if (data.contains("park")) {
            if (spots.any { it.equals(true) }) {
                println("${data[2]} car parked in spot ${spots.indexOf(true) + 1}.")
                spots[spots.indexOf(true)] = false

            } else if (spots.all { it.equals(false) }) {
                println("Sorry, the parking lot is full.")
            }
        } else if (data.contains("leave")) {

            if (!spots[data[1].toInt() - 1]) {

                println("Spot ${data[1]} is free.")
                spots[data[1].toInt() - 1] = true

            }
        } else if (data.contains("exit")) {
            break
        }



    }

}
