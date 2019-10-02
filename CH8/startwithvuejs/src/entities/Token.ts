
export class Token {
    accessToken: string = ''
    idToken: string = ''
    refreshToken: string = ''
    expiresOn: string = ''

    static emptyToken () {
      let delivery:Token = new Token()

      return delivery
    }

    static newToken (accessToken: string, idToken: string, refreshToken: string, expiresOn: string) {
      let token:Token = new Token()

      token.accessToken = accessToken
      token.idToken = idToken
      token.refreshToken = refreshToken
      token.expiresOn = expiresOn

      return token
    }

    copyToken (tokenToCopy: Token) {
      this.accessToken = tokenToCopy.accessToken
      this.idToken = tokenToCopy.idToken
      this.refreshToken = tokenToCopy.refreshToken
      this.expiresOn = tokenToCopy.expiresOn
    }
}
