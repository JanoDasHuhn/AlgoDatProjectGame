package rooms;

/**
 * Das Enum {@code RoomType} beschreibt die verschiedenen Typen von Räumen im Spiel.
 * Mögliche Typen sind:
 * <ul>
 *     <li>{@link #GOOD} – positive Räume, oft mit Belohnungen oder Vorteilen</li>
 *     <li>{@link #NEUTRAL} – neutrale Räume ohne besondere Gefahren oder Vorteile</li>
 *     <li>{@link #BAD} – gefährliche oder nachteilige Räume</li>
 * </ul>
 */
public enum RoomType {
    /** Positiver Raum (z.B. Belohnung, Heilung) */
    GOOD,
    /** Neutraler Raum (weder Vorteil noch Nachteil) */
    NEUTRAL,
    /** Gefährlicher Raum (z.B. Fallen, Gegner) */
    BAD
}
