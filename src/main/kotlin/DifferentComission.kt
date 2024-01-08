import kotlin.system.exitProcess

fun main() {
    transfer("VK Pay", 0, sumTransfer = 10000)
}

fun transfer(typeCard: String = "VK Pay", sumTransferForMonth: Int = 0, sumTransfer: Int) {
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
        println("Перевод отклонён! Вы превысили лимит").also { exitProcess(1) }

    if (typeCard == "VK Pay" && sumTransferForMonth + sumTransfer < limitsMonthVk && sumTransfer < limitsOneTimeVk)
        return println("Перевод прошёл успешно! Сумма перевода: $sumTransfer \nКомиссия составила: $commissionForVkPay")
    else if (typeCard != "VK Pay") null
    else println("Перевод отклонён! Превышен ежемесячный или ежедневный лимит").also { exitProcess(1) }

    if (typeCard == "Maestro" && sumTransferForMonth + sumTransfer < limitForCommissionMastercardOrMaestro)
        return println("Перевод прошёл успешно! Сумма перевода: $sumTransfer \nКомиссия составила: $commissionIntoLimit")
    else if (typeCard != "Maestro") null
    else println("Перевод прошёл успешно! Сумма перевода: $sumTransfer \nКомиссия составилa: $commissionWithoutLimit").also {
        exitProcess(
            1
        )
    }

    if (typeCard == "Mastercard" && sumTransferForMonth + sumTransfer < limitForCommissionMastercardOrMaestro)
        return println("Перевод прошёл успешно! Сумма перевода: $sumTransfer \nКомиссия составила: $commissionIntoLimit")
    else if (typeCard != "Mastercard") null
    else println("Перевод прошёл успешно! Сумма перевода: $sumTransfer \nКомиссия составилa: $commissionWithoutLimit").also {
        exitProcess(
            1
        )
    }

    if (typeCard == "Мир" && commissionForVisaAndMir > minCommissionForVisaAndMir)
        return println("Перевод прошёл успешно! Сумма перевода: ${sumTransfer} \nКомиссия составила: $commissionForVisaAndMir").also {
            exitProcess(
                1
            )
        }
    else if (commissionForVisaAndMir < minCommissionForVisaAndMir) return println("Перевод прошёл успешно! Сумма перевода: ${sumTransfer} \nКомиссия составила: $minCommissionForVisaAndMir").also {
        exitProcess(
            1
        )
    }
    else if (typeCard != "Мир") null

    if (typeCard == "Visa" && commissionForVisaAndMir > minCommissionForVisaAndMir)
        return println("Перевод прошёл успешно! Сумма перевода: ${sumTransfer} \nКомиссия составила: $commissionForVisaAndMir").also {
            exitProcess(
                1
            )
        }
    else if (commissionForVisaAndMir < minCommissionForVisaAndMir) return println("Перевод прошёл успешно! Сумма перевода: ${sumTransfer} \nКомиссия составила: $minCommissionForVisaAndMir").also {
        exitProcess(
            1
        )
    }
    else if (typeCard != "Visa") null

    if (typeCard != "VK Pay" && typeCard != "Mastercard" && typeCard != "Maestro" && typeCard != "Visa" && typeCard != "Мир")
        println("Введён неверный тип карты")


}