package mining.software.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gpu{

    //TODO @valid
    private String name;
    private Double price;
    private Double hashrate;
    private int powerConsumption;

}
