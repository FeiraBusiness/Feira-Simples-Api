package br.feira.domain.usecases.auth;

public record RegisterRequest(String username, String email, String password) {
}
