package agiletdd.exercices.common;

/**
 * Created by jzuriaga on 15/4/17.
 */
public class BusinessStaticDefaultFactory implements BusinessStaticFactory {

    @Override
    public BusinessStaticDelegate getBusinessStatic() {
        return BusinessStaticHolder.BUSINESS_STATIC.getBusinessStatic();
    }

    /**
     * Thread-safe implementation of BusinessStaticHolder.
     */
    private enum BusinessStaticHolder {
        BUSINESS_STATIC(new BusinessStaticDelegate());

        private BusinessStaticDelegate bizzStatic;

        BusinessStaticHolder(BusinessStaticDelegate businessStatic) {
            this.bizzStatic = businessStatic;
        }

        public BusinessStaticDelegate getBusinessStatic() {
            return this.bizzStatic;
        }
    }
}
