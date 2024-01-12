import kotlin.system.exitProcess

fun main() {
    println(transfer("Visa", 10000, sumTransfer = 100))
}

fun transfer(typeCard: String = "VK Pay", sumTransferForMonth: Int = 0, sumTransfer: Int) : Int {
    val errorTransfer = -1
    val limitsDayCard = 150_000
    val limitsMonthCard = 600_000
    val limitsOneTimeVk = 15_000
    val limitsMonthVk = 40_000
    val limitForCommissionMastercardOrMaestro = 75_000
    val commissionIntoLimit = 0
    val commissionWithoutLimit = 20 + (sumTransfer * 0.006)
    val minCommissionForVisaAndMir = 35
    val commissionForVisaAndMir = sumTransfer * 0.0075
    val commissionForVkPay = 0

    if (typeCard != "VK Pay" && sumTransfer > limitsDayCard || sumTransfer + sumTransferForMonth > limitsMonthCard)
        return errorTransfer

    if (typeCard == "VK Pay" && sumTransferForMonth + sumTransfer < limitsMonthVk && sumTransfer < limitsOneTimeVk)
        return commissionForVkPay
    else if (typeCard != "VK Pay") null
    else return errorTransfer

    if ((typeCard == "Maestro" || typeCard == "Mastercard") && sumTransferForMonth + sumTransfer < limitForCommissionMastercardOrMaestro)
        return commissionIntoLimit
    else if (typeCard != "Maestro" && typeCard != "Mastercard") null
    else return commissionWithoutLimit.toInt()


    if ((typeCard == "Мир" || typeCard == "Visa") && commissionForVisaAndMir > minCommissionForVisaAndMir)
        return commissionForVisaAndMir.toInt()
    else if (typeCard != "Мир" && typeCard != "Visa") null
    else  return minCommissionForVisaAndMir


    if (typeCard != "VK Pay" && typeCard != "Mastercard" && typeCard != "Maestro" && typeCard != "Visa" && typeCard != "Мир")
        return errorTransfer
    return 0

}