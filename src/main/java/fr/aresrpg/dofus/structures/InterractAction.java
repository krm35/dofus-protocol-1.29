package fr.aresrpg.dofus.structures;

/**
 * 
 * @since
 */
public enum InterractAction {
	// si tu veut t'amuser a traduire tout en anglais vas y
	SAVE_ZAAP(44),
	LOCK_HOUSE(81),
	OPEN_HOUSE(84),
	BUY_HOUSE(97),
	SELL(98),
	OPEN_CHEST(104),
	CHEST_CODE(105),
	UPDATE_SELL_PRICE(108),
	ZAAPI(157),
	PUISER(102),

	AMELIORER_BOTTES(163),
	AMELIORER_ANNEAU(168),
	AMELIORER_CHAPEAU(166),
	AMELIORER_SAC(167),
	AMELIORER_AMULETTE(169),
	AMELIORER_CAPE(165),
	AMELIORER_CEINTURE(164),
	BRICOLER(171),
	BRISER_OBJET(181),
	COLLECTER_FER(24),
	COLLECTER_CUIVRE(25),
	COLLECTER_BRONZE(26),
	COLLECTER_KOBALTE(28),
	COLLECTER_ARGENT(29),
	COLLECTER_OR(30),
	COLLECTER_BAUXITE(31),
	COLLECTER_ETEIN(55),
	COLLECTER_MANGANESE(56),
	COLLECTER_DOLOMITE(161),
	COLLECTER_SILICATE(162),
	CONCASSER_RESSOURCES(121),
	CONFECTIONNER_BOTTES(13),
	CONFECTIONNER_CEINTURE(14),
	CONFECTIONNER_CLEF(182),
	CONSULTER(170),
	COUDRE_CHAPEAU(63),
	COUDRE_SAC(123),
	COUDRE_CAP(64),
	COUPER_FRENE(6),
	COUPER_CHENE(10),
	COUPER_IF(33),
	COUPER_EBENE(449),
	COUPER_ORME(35),
	COUPER_ERABLE(37),
	COUPER_CHARME(38),
	COUPER_CHATAIGNIER(39),
	COUPER_NOYER(40),
	COUPER_MERISIER(41),
	COUPER_BOMBU(139),
	COUPER_OLIVIOLET(141),
	COUPER_BAMBOU(154),
	COUPER_BAMBOU_SOMBRE(155),
	COUPER_BAMBOU_SACRE(158),
	COUPER_KALIPTUS(174),
	CREER_ANNEAU(11),
	CREER_AMULETTE(12),
	CEUILLIR_LIN(68),
	CEUILLIR_CHANVRE(69),
	CEUILLIR_TREFLE(71),
	CEUILLIR_MENTHE(72),
	CEUILLIR_ORCHIDEE(73),
	CEUILLIR_EDELWEISS(74),
	CEUILLIR_GRAINE_PANDOUILLE(160),
	CUIR_PAIN(188),
	// DEVEROUILLER 100
	// DEVEROUILLER 106
	EGRENER(122),
	ENTRER(84),
	EPLUCHER(22),
	FAIRE_BIERE(96),
	FAIRE_BONBONS(109),
	FAUCHER_BLE(45),
	FAUCHER_HOUBLON(46),
	FAUCHER_LIN(50),
	FAUCHER_SEIGLE(52),
	FAUCHER_ORGE(53),
	FAUCHER_CHANVRE(54),
	FAUCHER_AVOINE(57),
	FAUCHER_MALT(58),;

	private int id;

	private InterractAction(int id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

}