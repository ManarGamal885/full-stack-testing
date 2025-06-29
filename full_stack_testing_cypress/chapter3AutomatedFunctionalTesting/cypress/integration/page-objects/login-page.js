export class LoginPage {
    login(email, password){
        cy.get('[data-qa="login-email"]', { timeout: 10000 }).should('be.visible').type(email)
        cy.get('[data-qa="login-password"]', { timeout: 10000 }).should('be.visible').type(password)
        cy.get('[data-qa="login-button"]', { timeout: 10000 }).should('be.visible').click()
    }
}