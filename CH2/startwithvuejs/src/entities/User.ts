export class User {
    private _username: string;
    private _password: string;
    private _role: string;
    constructor (username: string, password: string, role: string) {
      this._username = username
      this._password = password
      this._role = role
    }
    get username () {
      return this._username
    }
    get password () {
      return this._password
    }
    get role () {
      return this._role
    }
}
