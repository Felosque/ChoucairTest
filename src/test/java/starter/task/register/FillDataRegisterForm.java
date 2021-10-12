package starter.task.register;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;
import starter.ui.register.RegisterFieldsForm;
import starter.ui.register.RegisterForm;

public class FillDataRegisterForm implements Task {

    private final boolean male;
    public final String customerFirstName;
    public final String customerLastName;
    public final String customerEmail;
    public final String customerPassword;
    public final String selectDay;
    public final String selectMoth;
    public final String selectYear;
    public final boolean selectNewLetter;
    public final boolean selectSpecialOffers;
    public final String addressFirstName;
    public final String addressLastName;
    public final String addressCompany;
    public final String addressOne;
    public final String addressTwo;
    public final String addressCity;
    public final String addressState;
    public final String addressPostCode;
    public final String addressCountry;
    public final String addressInformation;
    public final String addressHomePhone;
    public final String addressMobilePhone;
    public final String addressAlias;

    public FillDataRegisterForm(boolean male, String customerFirstName, String customerLastName, String customerEmail,
                                String customerPassword, String selectDay, String selectMoth, String selectYear, boolean selectNewLetter,
                                boolean selectSpecialOffers, String addressFirstName, String addressLastName, String addressCompany,
                                String addressOne, String addressTwo, String addressCity, String addressState, String addressPostCode,
                                String addressCountry, String addressInformation, String addressHomePhone, String addressMobilePhone, String addressAlias) {
        this.male = male;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;
        this.selectDay = selectDay;
        this.selectMoth = selectMoth;
        this.selectYear = selectYear;
        this.selectNewLetter = selectNewLetter;
        this.selectSpecialOffers = selectSpecialOffers;
        this.addressFirstName = addressFirstName;
        this.addressLastName = addressLastName;
        this.addressCompany = addressCompany;
        this.addressOne = addressOne;
        this.addressTwo = addressTwo;
        this.addressCity = addressCity;
        this.addressState = addressState;
        this.addressPostCode = addressPostCode;
        this.addressCountry = addressCountry;
        this.addressInformation = addressInformation;
        this.addressHomePhone = addressHomePhone;
        this.addressMobilePhone = addressMobilePhone;
        this.addressAlias = addressAlias;
    }

    public static RegisterFormBuilder with(){
        return new RegisterFormBuilder();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Wait.until(
                        WebElementQuestion.the(RegisterFieldsForm.CUSTOMER_FIRST_NAME), WebElementStateMatchers.isEnabled())
                        .forNoLongerThan(30).seconds(),
                Enter.theValue(customerFirstName).into(RegisterFieldsForm.CUSTOMER_FIRST_NAME),
                Enter.theValue(customerLastName).into(RegisterFieldsForm.CUSTOMER_LAST_NAME),
                Enter.theValue(customerPassword).into(RegisterFieldsForm.CUSTOMER_PASSWORD),
                SelectFromOptions.byVisibleText(selectDay).from(RegisterFieldsForm.SELECT_DAY),
                SelectFromOptions.byVisibleText(selectMoth).from(RegisterFieldsForm.SELECT_MONTHS),
                SelectFromOptions.byVisibleText(selectYear).from(RegisterFieldsForm.SELECT_YEARS),
                Enter.theValue(addressCompany).into(RegisterFieldsForm.ADDRESS_COMPANY),
                Enter.theValue(addressOne).into(RegisterFieldsForm.ADDRESS_1),
                Enter.theValue(addressTwo).into(RegisterFieldsForm.ADDRESS_2),
                Enter.theValue(addressCity).into(RegisterFieldsForm.ADDRESS_CITY),
                SelectFromOptions.byVisibleText(addressState).from(RegisterFieldsForm.ADDRESS_STATE),
                Enter.theValue(addressPostCode).into(RegisterFieldsForm.ADDRESS_POST_CODE),
                SelectFromOptions.byVisibleText(addressCountry).from(RegisterFieldsForm.ADDRESS_COUNTRY),
                Enter.theValue(addressInformation).into(RegisterFieldsForm.ADDRESS_ADDITIONAL_INFORMATION),
                Enter.theValue(addressHomePhone).into(RegisterFieldsForm.ADDRESS_HOME_PHONE),
                Enter.theValue(addressMobilePhone).into(RegisterFieldsForm.ADDRESS_MOBILE_PHONE)
        );

        if (male){
            actor.attemptsTo(Click.on(RegisterFieldsForm.GENDER_MALE));
        }else{
            actor.attemptsTo(Click.on(RegisterFieldsForm.GENDER_FEMALE));
        }

        if (selectNewLetter){
            actor.attemptsTo(Click.on(RegisterFieldsForm.SELECT_NEWSLETTER));
        }
        if (selectSpecialOffers){
            actor.attemptsTo(Click.on(RegisterFieldsForm.SELECT_SPECIAL_OFFERS));
        }

        actor.attemptsTo(
                Click.on(RegisterFieldsForm.SUBMIT_BUTTON)
        );
    }

    public static class RegisterFormBuilder{
        private boolean male;
        public String customerFirstName;
        public String customerLastName;
        public String customerEmail;
        public String customerPassword;
        public String selectDay;
        public String selectMoth;
        public String selectYear;
        public boolean selectNewLetter;
        public boolean selectSpecialOffers;
        public String addressFirstName;
        public String addressLastName;
        public String addressCompany;
        public String addressOne;
        public String addressTwo;
        public String addressCity;
        public String addressState;
        public String addressPostCode;
        public String addressCountry;
        public String addressInformation;
        public String addressHomePhone;
        public String addressMobilePhone;
        public String addressAlias;

        public RegisterFormBuilder isMale(boolean male) {
            this.male = male;
            return this;
        }

        public RegisterFormBuilder setCustomerFirstName(String customerFirstName) {
            this.customerFirstName = customerFirstName;
            return this;
        }

        public RegisterFormBuilder setCustomerLastName(String customerLastName) {
            this.customerLastName = customerLastName;
            return this;
        }

        public RegisterFormBuilder setCustomerEmail(String customerEmail) {
            this.customerEmail = customerEmail;
            return this;
        }

        public RegisterFormBuilder setCustomerPassword(String customerPassword) {
            this.customerPassword = customerPassword;
            return this;
        }

        public RegisterFormBuilder birthday(String selectDay) {
            this.selectDay = selectDay;
            return this;
        }

        public RegisterFormBuilder birthdayMonth(String selectMoth) {
            this.selectMoth = selectMoth;
            return this;
        }

        public RegisterFormBuilder birthdayYear(String selectYear) {
            this.selectYear = selectYear;
            return this;
        }

        public RegisterFormBuilder suscribeToNewsLetter(boolean selectNewLetter) {
            this.selectNewLetter = selectNewLetter;
            return this;
        }

        public RegisterFormBuilder suscribeToSpecialOffers(boolean selectSpecialOffers) {
            this.selectSpecialOffers = selectSpecialOffers;
            return this;
        }

        public RegisterFormBuilder setAddressFirstName(String addressFirstName) {
            this.addressFirstName = addressFirstName;
            return this;
        }

        public RegisterFormBuilder setAddressLastName(String addressLastName) {
            this.addressLastName = addressLastName;
            return this;
        }

        public RegisterFormBuilder setAddressCompany(String addressCompany) {
            this.addressCompany = addressCompany;
            return this;
        }

        public RegisterFormBuilder setAddressOne(String addressOne) {
            this.addressOne = addressOne;
            return this;
        }

        public RegisterFormBuilder setAddressTwo(String addressTwo) {
            this.addressTwo = addressTwo;
            return this;
        }

        public RegisterFormBuilder setAddressCity(String addressCity) {
            this.addressCity = addressCity;
            return this;
        }

        public RegisterFormBuilder setAddressState(String addressState) {
            this.addressState = addressState;
            return this;
        }

        public RegisterFormBuilder setAddressPostCode(String addressPostCode) {
            this.addressPostCode = addressPostCode;
            return this;
        }

        public RegisterFormBuilder setAddressCountry(String addressCountry) {
            this.addressCountry = addressCountry;
            return this;
        }

        public RegisterFormBuilder setAddressInformation(String addressInformation) {
            this.addressInformation = addressInformation;
            return this;
        }

        public RegisterFormBuilder setAddressHomePhone(String addressHomePhone) {
            this.addressHomePhone = addressHomePhone;
            return this;
        }

        public RegisterFormBuilder setAddressMobilePhone(String addressMobilePhone) {
            this.addressMobilePhone = addressMobilePhone;
            return this;
        }

        public RegisterFormBuilder setAddressAlias(String addressAlias) {
            this.addressAlias = addressAlias;
            return this;
        }

        public Performable build(){
            return new FillDataRegisterForm( male,  customerFirstName,  customerLastName,  customerEmail,
                     customerPassword,  selectDay,  selectMoth,  selectYear,  selectNewLetter,
                     selectSpecialOffers,  addressFirstName,  addressLastName,  addressCompany,  addressOne,
                     addressTwo,  addressCity,  addressState,  addressPostCode,  addressCountry,
                     addressInformation,  addressHomePhone,  addressMobilePhone, addressAlias);
        }
    }
}
