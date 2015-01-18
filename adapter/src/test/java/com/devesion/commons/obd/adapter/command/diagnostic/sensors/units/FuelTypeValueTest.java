package com.devesion.commons.obd.adapter.command.diagnostic.sensors.units;

import com.devesion.commons.obd.adapter.command.CommandResult;
import com.google.common.base.Optional;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.devesion.commons.obd.adapter.command.diagnostic.sensors.units.FuelTypeValue.FuelType;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class FuelTypeValueTest {

	@Mock
	private CommandResult commandResultMock;

	private FuelTypeValue sut;

	@BeforeMethod
	private void beforeMethod() {
		initMocks(this);
		sut = new FuelTypeValue(commandResultMock);
	}

	@Test
	public void getTypeShouldSelectProperEnumType() throws Exception {
		// given

		// when
		boolean fuelTypesAreEqual = true;
		for (FuelType expectedFuelType : FuelType.values()) {
			when(commandResultMock.getByteNumber(0)).thenReturn(expectedFuelType.getTypeNumber());
			Optional<FuelType> fuelTypeOptional = sut.getType();
			FuelType fuelType = fuelTypeOptional.get();
			fuelTypesAreEqual &= fuelType.equals(expectedFuelType);
		}

		// then
		assertThat(fuelTypesAreEqual).isTrue();
	}

	@Test
	public void getTypeShouldReturnAbsentForUnknownFuelTypeByte() throws Exception {
		// given
		int maxFuelTypeNumber = getMaxFuelTypeNumber();
		int unknownFuelTypeNumber = maxFuelTypeNumber + 1;
		when(commandResultMock.getByteNumber(0)).thenReturn(unknownFuelTypeNumber);

		// when
		Optional<FuelType> fuelTypeOptional = sut.getType();

		// then
		assertThat(fuelTypeOptional.isPresent()).isFalse();
	}

	private int getMaxFuelTypeNumber() {
		int maxFuelTypeNumber = 0;
		for (FuelType fuelType : FuelType.values()) {
			int fuelTypeNumber = fuelType.getTypeNumber();
			maxFuelTypeNumber = (maxFuelTypeNumber > fuelTypeNumber) ? maxFuelTypeNumber : fuelTypeNumber;
		}

		return maxFuelTypeNumber;
	}
}