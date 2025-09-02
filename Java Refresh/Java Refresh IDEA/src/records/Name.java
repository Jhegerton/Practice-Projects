package records;

import java.util.Objects;

public record Name(
        Integer count,             // number of people with that name
        Integer cumProp,           // cumulative proportion per 100,000 population
        String  name,              // surname
        Integer perMultiRace,      // percent multi race
        Integer perNatveAmerican,  // percent native american
        Integer perAsianPacificI,  // percent asian pacific islander
        Integer perBlack,          // percent black
        Integer perHispanic,       // percent hispanic
        Integer perWhite,          // percent white
        Integer prop,              // proportion per 100,000 population
        Integer rank               // national rank
) { }