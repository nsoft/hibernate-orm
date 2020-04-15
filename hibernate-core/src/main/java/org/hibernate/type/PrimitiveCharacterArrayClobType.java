/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.type;
import org.hibernate.type.descriptor.java.PrimitiveCharacterArrayTypeDescriptor;
import org.hibernate.type.descriptor.sql.ClobTypeDescriptor;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptorIndicators;

/**
 * Map a char[] to a Clob
 *
 * @author Emmanuel Bernard
 */
public class PrimitiveCharacterArrayClobType
		extends AbstractSingleColumnStandardBasicType<char[]>
		implements SqlTypeDescriptorIndicatorCapable<char[]> {
	public static final CharacterArrayClobType INSTANCE = new CharacterArrayClobType();

	public PrimitiveCharacterArrayClobType() {
		super( ClobTypeDescriptor.DEFAULT, PrimitiveCharacterArrayTypeDescriptor.INSTANCE );
	}

	public String getName() {
		// todo name these annotation types for addition to the registry
		return null;
	}

	@Override
	public <X> BasicType<X> resolveIndicatedType(SqlTypeDescriptorIndicators indicators) {
		if ( indicators.isNationalized() ) {
			//noinspection unchecked
			return (BasicType<X>) PrimitiveCharacterArrayNClobType.INSTANCE;
		}

		//noinspection unchecked
		return (BasicType<X>) this;
	}
}
