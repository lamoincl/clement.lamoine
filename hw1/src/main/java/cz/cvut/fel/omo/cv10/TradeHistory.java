package cz.cvut.fel.omo.cv10;

import java.util.*;
import java.util.stream.Collectors;

public class TradeHistory {

    public List<Transaction> transactions;

    public TradeHistory(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Transaction> findAllTransactionsIn2011AndSortByValueAsc(){
        return transactions.stream()
                .filter(x->x.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
    }

    public List<String> getUniqueCitiesSortedAsc(){
        return transactions.stream()
                .map(x -> x.getTrader().getCity())
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }

    /*
    * String shall start with "Traders:" and use space as separator. E.g.: "Traders: Bob George"
    *
     */
    public String getSingleStringFromUniqueTradersNamesSortByNameAsc(){
        return transactions.stream()
                .map(x -> x.getTrader().getName())
                .sorted()
                .distinct()
                .reduce("Traders:", (tradersStr, nameStr) -> tradersStr + " " + nameStr);
    }

    public boolean isSomeTraderFromCity(String cityName){
        return transactions.stream()
                .anyMatch(x -> x.getTrader().getCity().equals(cityName));
    }

    public Optional<Transaction> findSmallestTransactionUsingReduce(){
        Optional<Transaction> smallestTransaction = null;
        //Implement body here
        return smallestTransaction;
    }

    public Map<String, List<Trader>> getTradersByTown(){
        Map<String, List<Trader>> tradersByTown = new HashMap<String, List<Trader>>();
        //Implement body here
        return tradersByTown;
    }

    public Map<String, Long> getTradersCountsByTown(){
        Map<String, Long> tradersByTown = new HashMap<String, Long>();
        //Implement body here
        return tradersByTown;
    }

    public Map<Boolean, List<Transaction>> partitionTransactionsByTraderIsVegetarian(){
        Map<Boolean, List<Transaction>> transactionsBy = new HashMap<Boolean, List<Transaction>>();
        return transactionsBy;
    }
}
