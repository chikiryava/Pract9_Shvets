import Film.Cinema

fun main()
{
    println("Введите с каким классом хотите работать(drive/cinema)")
    var choise: String = readLine()!!.toString()
    while(choise != "drive" && choise != "cinema")
    {
        println("Введите с каким классом хотите работать(drive/cinema)")
        choise = readLine()!!.toString()
    }
    when{
        (choise == "drive") -> {
            val travel: Drive = Drive(5)
            travel.Input()
            travel.Output()
            travel.NumberOfDaysOnTheRoad()
        }
        (choise == "cinema") -> {
            val cinema: Cinema = Cinema("Чебурашка")
            cinema.Input()
            cinema.Output()
            cinema.AgeLimit()
            cinema.Revenue()
        }
    }
}




