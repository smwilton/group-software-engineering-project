/**
 * 
 */
package druidsAndMana;

/**
 * Enum that lists the Realm Tiers that a Grassland can be instantiated with.
 * 
 * @author Nicola
 *
 */
public enum RealmTier {
	TIER_1, TIER_2, TIER_3, TIER_4

	/*
	 * Design Decision to make this RealmTiers rather than Realm so it is more
	 * meaningful and less linked to the Realms which will allow for future growth.
	 * So e.g. with growth a Tropical Grassland could be instantiated with TIER_1 or
	 * TIER_2 even though current logic means it is always instantiated with TIER_1
	 */
}
