package mining.software.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//TODO @valid

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gpu implements Serializable {

    private String name;
    private Double price;
    private Double hashrate;
    private int powerConsumption;

}
