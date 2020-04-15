/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.hibernate.metamodel.mapping;

import org.hibernate.type.descriptor.java.JavaTypeDescriptor;

/**
 * @author Steve Ebersole
 */
public interface EntityDiscriminatorMapping extends VirtualModelPart, BasicValuedModelPart {
	String ROLE_NAME = "{discriminator}";

	@Override
	default String getPartName() {
		return ROLE_NAME;
	}

	@Override
	default MappingType getPartMappingType() {
		return this::getJavaTypeDescriptor;
	}

	@Override
	default JavaTypeDescriptor getJavaTypeDescriptor() {
		return null;
	}
}
