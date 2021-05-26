package mining.software.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//TODO @valid

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StartData {
    private double dailyProfit;
    private double pricePerKw;
    private double allFees; //including pool fee, transaction fee etc.
}
