package agiletdd.exercices;

public class RefactorMagicNumber {

	private static final float VAT_TAX = 0.21f;

	public float calculatePrizeAfterTax(float prize){
		
		return prize + (prize * VAT_TAX);
		
	}
	


}
