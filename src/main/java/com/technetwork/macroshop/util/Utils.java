package com.technetwork.macroshop.util;

import com.technetwork.macroshop.model.Product;
import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@UtilityClass
public class Utils {

    public static List<Long> csvNumbersToLongList(String csvNumbers) {
        return Arrays.stream(csvNumbers.split(","))
                .map(Long::parseLong)
                .collect(toList());
    }

    public static boolean isValidTransaction(Double buyingWallet, List<Product> products) {
        boolean availableStock = products.stream()
                .allMatch(product -> product.getStock() > 0);

        boolean enoughMoney = (Double) products.stream()
                .mapToDouble(Product::getPrice).sum() <= buyingWallet;

        return availableStock && enoughMoney;
    }

    public static List<Integer> generateRange(int totalPages) {
        return IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(toList());
    }

}