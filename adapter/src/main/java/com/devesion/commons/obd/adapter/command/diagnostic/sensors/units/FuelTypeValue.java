package com.devesion.commons.obd.adapter.command.diagnostic.sensors.units;

import com.devesion.commons.obd.adapter.command.CommandResult;
import com.google.common.base.Optional;
import lombok.AccessLevel;
import lombok.Getter;

/**
 * Represents Fuel Type Value Object.
 */
class FuelTypeValue extends AbstractSensorCommandValue {

	public FuelTypeValue(CommandResult commandResult) {
		super(commandResult);
	}

	@Override
	protected float calculateValue() {
		return getResultByteNumber(0);
	}

	public Optional<FuelType> getType() {
		return FuelType.valueOf(getIntValue());
	}

	public enum FuelType {
		GASOLINE(0x01),
		METHANOL(0x02),
		ETHANOL(0x03),
		DIESEL(0x04),
		LPG(0x05),
		CNG(0x06),
		PROPANE(0x07),
		ELECTRIC(0x08),
		BIFUEL_RUNNING_GASOLINE(0x09),
		BIFUEL_RUNNING_METHANOL(0x0A),
		BIFUEL_RUNNING_ETHANOL(0x0B),
		BIFUEL_RUNNING_LPG(0x0C),
		BIFUEL_RUNNING_CNG(0x0D),
		BIFUEL_RUNNING_PROPANE(0x0E),
		BIFUEL_RUNNING_ELECTRIC(0x0F),
		BIFUEL_RUNNING_GASOLINE_ELECTRIC(0x10),
		HYBRID_GASOLINE(0x11),
		HYBRID_ETHANOL(0x12),
		HYBRID_DIESEL(0x13),
		HYBRID_ELECTRIC(0x14),
		HYBRID_MIXED(0x15),
		HYBRID_REGENERATIVE(0x16);

		@Getter(AccessLevel.PACKAGE)
		private int typeNumber;

		FuelType(int typeNumber) {
			this.typeNumber = typeNumber;
		}

		public static Optional<FuelType> valueOf(int typeNumber) {
			for (FuelType type : values()) {
				if (type.typeNumber == typeNumber) {
					return Optional.of(type);
				}
			}

			return Optional.absent();
		}
	}
}
