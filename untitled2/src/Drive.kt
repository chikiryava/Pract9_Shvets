import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.Period
import java.time.temporal.ChronoUnit
import kotlin.Exception
class Drive(_number: Int)
{
        var number = _number
        var destination: String = "Екатерибург"
        var days_of_travel: String = "10.02.2023-15.02.2023"
        var arrival_time: String = "21:15"
        var time_stop: Int = 0
        constructor(_number: Int, _destination: String) : this(_number)
        {
            destination = _destination
        }
        constructor(_number: Int, _destination: String, _days_of_travel: String) : this(_number, _destination)
        {
            days_of_travel = _days_of_travel
        }
        fun NumberOfDaysOnTheRoad() {
        val delimiter = '-'
        var list = days_of_travel.split(delimiter)
        val dateFormatInput1 = DateTimeFormatter.ofPattern("yyyy.MM.dd")
        val data1 = LocalDate.parse( list[0], dateFormatInput1)
        val data2 = LocalDate.parse(list[1], dateFormatInput1)
        val raznitsa = ChronoUnit.DAYS.between(data1, data2) + 1
        println("$raznitsa cуток(и) в пути")
        }

        fun Output() {
            print("Номер поезда: ")
            println(number)
            print("Пункт назначения: ")
            println(destination)
            print("Дни следования: ")
            println(days_of_travel)
            print("Время прибытия: ")
            println(arrival_time)
            print("Время стоянки: ")
            println(time_stop)
        }

        fun Input() {
            while(true)
            {
                try {
                    println("Введите номер поезда")
                    number = readLine()!!.toInt()
                    while (number !in  0 ..1000) {
                        println("Номер поезда в диапозоне от 0 до 100")
                        number = readLine()!!.toInt()
                    }
                    println("Введите пункт назначения")
                    destination = readLine()!!.toString()
                    println("Введите дни следования в формате dd.MM.yyyy-dd.MM.yyyy")
                    days_of_travel = readLine()!!.toString()
                    while(true)
                    {
                        try
                        {
                            var list1 = days_of_travel.split('-')
                            val dateFormatInput1 = DateTimeFormatter.ofPattern("dd.MM.yyyy")
                            val data1: LocalDate = LocalDate.parse( list1[0], dateFormatInput1)
                            val data2: LocalDate = LocalDate.parse(list1[1], dateFormatInput1)
                            var data1_string = data1.toString().replace('-', '.')
                            var data2_string = data2.toString().replace('-', '.')
                            days_of_travel = "${data1_string}-${data2_string}"
                            break
                        }
                        catch (e: Exception)
                        {
                            println("Введите дату в правильном формате")
                            days_of_travel = readLine()!!.toString()
                        }
                    }
                    println("Введите время прибытия в формате НН:mm")
                    arrival_time = readLine()!!.toString()
                    while(true) {
                        try {
                            while (true) {
                                var list2 = arrival_time.split(':')
                                var hours: Int = list2[0].toInt()
                                var minutes: Int = list2[1].toInt()
                                if (hours in 1..23) {
                                    if (minutes in 1..59)
                                        break
                                } else {
                                    println("Введите время в правильном формате")
                                    arrival_time = readLine()!!.toString()
                                }
                            }
                            break
                        }
                        catch (e: Exception)
                        {
                            println("Введите время в правильном формате")
                            arrival_time = readLine()!!.toString()
                        }
                    }
                    println("Введите время стоянки в минутах")
                    time_stop = readLine()!!.toInt()
                    while (time_stop !in 1..180) {
                        println("Время стоянки в диапозоне от 0 до 180")
                        time_stop = readLine()!!.toInt()
                    }
                    break
                }
                catch (e: Exception)
                {
                    println("Неправильный ввод")
                }
            }
        }



}
