class LoginPage {
  get username() { return $('#username'); }
  get password() { return $('#password'); }
  get loginBtn() { return $('#loginBtn'); }

  async open() {
    await browser.url('http://127.0.0.1:8081/login.html');
  }

  async login(user, pass) {
    await this.username.setValue(user);
    await this.password.setValue(pass);
    await this.loginBtn.click();
  }
}
export default new LoginPage();
