package com.shankulk.helper;

import com.shankulk.dto.PursuitDto;

public class TestFixtures {

  private TestFixtures() {}

  public static PursuitDto pursuitFixture() {
    PursuitDto pursuitDto = new PursuitDto();
    pursuitDto.setPursuitName("first pursuit");
    pursuitDto.setObjectiveName("first objective");
    pursuitDto.setComparator("GT");
    pursuitDto.setMetric("login");
    pursuitDto.setValue(10.10);
    return pursuitDto;
  }
}
