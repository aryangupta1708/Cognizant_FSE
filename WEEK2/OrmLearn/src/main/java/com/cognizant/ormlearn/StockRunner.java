package com.cognizant.ormlearn;

import com.cognizant.ormlearn.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class StockRunner implements CommandLineRunner {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public void run(String... args) {


        System.out.println("Facebook - September 2019");

        stockRepository.findByCodeAndDateBetween(
                        "FB",
                        LocalDate.of(2019, 9, 1),
                        LocalDate.of(2019, 9, 30))
                .forEach(System.out::println);



        System.out.println("Google Close > 1250");


        stockRepository.findByCodeAndCloseGreaterThan(
                        "GOOGL",
                        1250)
                .forEach(System.out::println);



        System.out.println("Top 3 Highest Volume");
               stockRepository.findTop3ByOrderByVolumeDesc()
                .forEach(System.out::println);



        System.out.println("Lowest Netflix Stocks");
               stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX")
                .forEach(System.out::println);
    }
}