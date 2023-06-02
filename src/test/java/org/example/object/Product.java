package org.example.object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {


    private String name;
    private String weight;
    private Double price;
    private Double totalPrice;
    private int numberOfPieces;


}
