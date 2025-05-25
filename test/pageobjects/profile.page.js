class ProfilePage {
  get nameField() { return $('#name'); }
  get emailField() { return $('#email'); }
  get updateBtn() { return $('#updateBtn'); }

  async updateProfile(name, email) {
    await this.nameField.setValue(name);
    await this.emailField.setValue(email);
    await this.updateBtn.click();
  }

  async isUpdateSuccessful() {
    return await $('#successToast').isDisplayed();
  }
}
export default new ProfilePage();
