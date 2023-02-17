package Film
import java.time.LocalDate
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString

open class Cinema(_name: String)
{
    constructor(_name: String, _price: Double) : this(_name)
    {
        price = _price
    }
    constructor(_name: String, _price: Double, _hall: Int) : this(_name, _price)
    {
       hall = _hall
    }
    private var name = _name
    private var session: String = "23.25"
    private var price: Double = 299.99
    private var hall: Int = 5
    private var number_of_spectators: Int = 100
    private var age: Int=15
    open fun AgeLimit(){

            println("Введите возрастное ограничение для фильма")
            while(true) {
                try {
                    age= readLine()!!.toInt()
                    if (age < 0)
                        println("Возраст не может быть меньше 0")
                    if(age!=0 && age!=6 && age!=12&&age!=16&&age!=18)
                        println("Введите возрастное ограничение в соответствии с нормой(0,6,12,16,18)")
                    else
                        break
                }
                catch(e:Exception){
                    println("Вы ввели не число")
                }
            }
       println("Возрастное ограничение фильма - ${age}+")
        }
    open fun Revenue(){
        val viruchka:Double = number_of_spectators*price
        when(viruchka){
            in 0.0..3000.0 -> println("Низкая выручка за один сеанс")
            in 3000.0..7000.0-> println("Средняя выручка за один сеанс")
            else -> println("Высокая выручка за один сеанс")
        }
    }
    open fun Input()
    {
        println("Введите название фильма")
        name = readLine()!!.toString()
        println("Введите время сеанса в формате НН.mm")
        session = readLine()!!.toString()
        while(true) {
            try {
                while (true) {
                    var list2 = session.split('.')
                    var hours: Int = list2[0].toInt()
                    var minutes: Int = list2[1].toInt()
                    if (hours in 1..23) {
                        if (minutes in 1..59)
                            break
                    } else {
                        println("Введите время в правильном формате")
                        session = readLine()!!.toString()
                    }
                }
                break
            }
            catch (e: Exception)
            {
                println("Введите время в правильном формате")
                session = readLine()!!.toString()
            }
        }
        while(true) {
            try {
                println("Введите стоимость билета")
                price = readLine()!!.toDouble()
                while (price < 0) {
                    println("Стоимость больше 0")
                    price = readLine()!!.toDouble()
                }
                break
            }
            catch (e: Exception){
                println("Введите число")
                price = readLine()!!.toDouble()
            }
        }
        while(true) {
            try {
                println("Введите номер зала")
                hall = readLine()!!.toInt()
                while (hall < 0) {
                    println("Номер зала больше 0")
                    hall = readLine()!!.toInt()
                }
                break
            }
            catch (e: Exception){
                println("Введите число")
                hall = readLine()!!.toInt()
            }
        }

        while(true){
            try {
                println("Введите количество зрителей")
                number_of_spectators = readLine()!!.toInt()
                while (number_of_spectators !in  0 ..3000) {
                    println("Количество зрителей в диапозоне от 0 до 3000")
                    number_of_spectators = readLine()!!.toInt()
                }
                break
            }
            catch (e: Exception){
                println("Введите число")
                number_of_spectators = readLine()!!.toInt()
            }
        }

    }
    open fun Output()
    {
        print("Название фильма: ")
        println(name)
        print("Время сеанса: ")
        println(session)
        print("Стоимость билета: ")
        println(price)
        print("Номер зала: ")
        println(hall)
        println("Количество зрителей")
        println(number_of_spectators)
    }
}