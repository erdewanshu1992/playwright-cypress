class DashboardPage {
  get welcomeMsg() { return $('#welcome'); }
  get profileLink() { return $('#profileLink'); }

  async goToProfile() {
    await this.profileLink.click();
  }

  async isLoaded() {
    return await this.welcomeMsg.isDisplayed();
  }
}
export default new DashboardPage();
