package util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Resources {
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY =
			Persistence.createEntityManagerFactory("project");

	public static EntityManagerFactory getEntityManagerFactory() {
		return ENTITY_MANAGER_FACTORY;
	}
}
