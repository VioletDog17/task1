fun main(args: Array<String>) {
    var orderSum = 999;
    var sale = 0;
    var customerStatus = true;
    var lastSum = 0
    var card = "VK Pay"
    if(orderSum in 0..1000){
        sale = 0
    }else if (orderSum in 1001..10_000){
        sale =100
    }else{
        sale = ((orderSum/100)*5)
    }
    if(customerStatus){
        sale += (orderSum / 100) * 1
    }
    println(sale) // без учета карты

    println(cardType(card, lastSum, orderSum))
    lastSum += orderSum
}

fun cardType (card: String, lastSum: Int, sum: Int): Int {
    var ans = 0
    var limitChecker = false
    if(lastSum> 75_000){
        limitChecker=false
    }else{
        limitChecker=true
    }
 when(card){
     "VK Pay" -> ans=0

     "Mastercard", "Maestro" -> if(limitChecker){ans =0}else {ans = (sum*0.06 + 20).toInt()}

     "Visa", "Мир" -> if(sum*0.75<35){ans = 35}else{ans = (sum * 0.75).toInt()}
 }
    return ans
}