import org.junit.Test

import org.junit.Assert.*

class DifferentComissionKtTest {


    @Test
    fun transferVkPayIntoLimit() {
        val typeCard = "VK Pay"
        val sumTransferForMonth = 1000
        val sumTransfer = 1000
        val commissionForVkPay = 0

        val result = transfer(typeCard, sumTransferForMonth, sumTransfer)

        assertEquals(commissionForVkPay, result)
    }

    @Test
    fun transferVkPayOutLimit() {
        val typeCard = "VK Pay"
        val sumTransferForMonth = 1000
        val sumTransfer = 100000
        val errorTransfer = -1

        val result = transfer(typeCard, sumTransferForMonth, sumTransfer)

        assertEquals(errorTransfer, result)
    }

    @Test
    fun transferMaestroIntoLimitWithoutCommission() {
        val typeCard = "Maestro"
        val sumTransferForMonth = 10000
        val sumTransfer = 10000
        val commissionIntoLimit = 0

        val result = transfer(typeCard, sumTransferForMonth, sumTransfer)

        assertEquals(commissionIntoLimit, result)
    }

    @Test
    fun transferMaestroIntoLimitWithCommission() {
        val typeCard = "Maestro"
        val sumTransferForMonth = 80000
        val sumTransfer = 10000
        val commissionWithoutLimit = 20 + (sumTransfer * 0.006).toInt()

        val result = transfer(typeCard, sumTransferForMonth, sumTransfer)

        assertEquals(commissionWithoutLimit, result)
    }

    @Test
    fun transferMaestroOutLimit() {
        val typeCard = "Maestro"
        val sumTransferForMonth = 800000
        val sumTransfer = 10000
        val errorTransfer = -1

        val result = transfer(typeCard, sumTransferForMonth, sumTransfer)

        assertEquals(errorTransfer, result)
    }

    @Test
    fun transferMastercardOutLimit() {
        val typeCard = "Mastercard"
        val sumTransferForMonth = 800000
        val sumTransfer = 10000
        val errorTransfer = -1

        val result = transfer(typeCard, sumTransferForMonth, sumTransfer)

        assertEquals(errorTransfer, result)
    }

    @Test
    fun transferMastercardIntoLimitWithoutCommission() {
        val typeCard = "Mastercard"
        val sumTransferForMonth = 10000
        val sumTransfer = 10000
        val commissionIntoLimit = 0

        val result = transfer(typeCard, sumTransferForMonth, sumTransfer)

        assertEquals(commissionIntoLimit, result)
    }

    @Test
    fun transferMastercardIntoLimitWithCommission() {
        val typeCard = "Mastercard"
        val sumTransferForMonth = 80000
        val sumTransfer = 10000
        val commissionWithoutLimit = 20 + (sumTransfer * 0.006).toInt()

        val result = transfer(typeCard, sumTransferForMonth, sumTransfer)

        assertEquals(commissionWithoutLimit, result)
    }

    @Test
    fun transferMirIntoLimitWithCommission() {
        val typeCard = "Мир"
        val sumTransferForMonth = 80000
        val sumTransfer = 10000
        val commissionForVisaAndMir = (sumTransfer * 0.0075).toInt()

        val result = transfer(typeCard, sumTransferForMonth, sumTransfer)

        assertEquals(commissionForVisaAndMir, result)
    }

    @Test
    fun transferMirIntoLimitWithMinCommission() {
        val typeCard = "Мир"
        val sumTransferForMonth = 80000
        val sumTransfer = 1000
        val minCommissionForVisaAndMir = 35

        val result = transfer(typeCard, sumTransferForMonth, sumTransfer)

        assertEquals(minCommissionForVisaAndMir, result)
    }

    @Test
    fun transferMirOutLimit() {
        val typeCard = "Мир"
        val sumTransferForMonth = 800000
        val sumTransfer = 1000
        val errorTransfer = -1

        val result = transfer(typeCard, sumTransferForMonth, sumTransfer)

        assertEquals(errorTransfer, result)
    }

    @Test
    fun transferVisaIntoLimitWithCommission() {
        val typeCard = "Visa"
        val sumTransferForMonth = 80000
        val sumTransfer = 10000
        val commissionForVisaAndMir = (sumTransfer * 0.0075).toInt()

        val result = transfer(typeCard, sumTransferForMonth, sumTransfer)

        assertEquals(commissionForVisaAndMir, result)
    }

    @Test
    fun transferVisaIntoLimitWithMinCommission() {
        val typeCard = "Visa"
        val sumTransferForMonth = 80000
        val sumTransfer = 1000
        val minCommissionForVisaAndMir = 35

        val result = transfer(typeCard, sumTransferForMonth, sumTransfer)

        assertEquals(minCommissionForVisaAndMir, result)
    }

    @Test
    fun transferVisaOutLimit() {
        val typeCard = "Visa"
        val sumTransferForMonth = 800000
        val sumTransfer = 1000
        val errorTransfer = -1

        val result = transfer(typeCard, sumTransferForMonth, sumTransfer)

        assertEquals(errorTransfer, result)
    }
    @Test
    fun transferNoNameCardOutLimit() {
        val typeCard = "No name"
        val sumTransferForMonth = 800000
        val sumTransfer = 1000
        val errorTransfer = -1

        val result = transfer(typeCard, sumTransferForMonth, sumTransfer)

        assertEquals(errorTransfer, result)
    }

    @Test
    fun transferNoNameCardIntoLimit() {
        val typeCard = "Card"
        val sumTransferForMonth = 10000
        val sumTransfer = 10000
        val errorTransfer = -1

        val result = transfer(typeCard, sumTransferForMonth, sumTransfer)

        assertEquals(errorTransfer, result)
    }

    @Test
    fun transferNoNameCardIntoLimitMin() {
        val typeCard = "Card"
        val sumTransferForMonth = 10000
        val sumTransfer = 100
        val errorTransfer = 1

        val result = transfer(typeCard, sumTransferForMonth, sumTransfer)

        assertEquals(errorTransfer, result)
    }
}