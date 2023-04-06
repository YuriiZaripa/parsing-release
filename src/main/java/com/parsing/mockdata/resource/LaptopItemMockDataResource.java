package com.parsing.mockdata.resource;

import com.parsing.mockdata.for_manual_testing_rozetkz_parsing_item.LaptopItemMockDataGenerator;
import com.parsing.model.LaptopItem;
import com.parsing.model.LotPDFResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/rozetka-parser/generator/laptop-item")
public class LaptopItemMockDataResource {

    private final LaptopItemMockDataGenerator laptopItemMockDataGenerator;

    @PostMapping
    public List<LaptopItem> generate(@RequestBody LotPDFResult lotPDFResult) {
        return laptopItemMockDataGenerator.generate(lotPDFResult);
    }
}
