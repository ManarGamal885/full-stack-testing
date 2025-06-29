import { LoginPage } from "../integration/page-objects/login-page";
import { HomePage } from "../integration/page-objects/home-page";

describe('example to-do app', () => {
    const loginPage = new LoginPage();
    const homePage = new HomePage();

    beforeEach(() => {
        cy.visit('https://www.automationexercise.com/login');
    });

    it('should login and land on the home page', () => {
        loginPage.login('test1234@test1234.com', 'test1234');
        homePage.getTitle().should('have.string', 'Automation Exercise');
    });
});
