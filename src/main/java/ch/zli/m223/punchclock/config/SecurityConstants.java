package ch.zli.m223.punchclock.config;

public class SecurityConstants {
    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/sign-up.html";
    public static final String SIGN_UP_URL_JS = "/sign-up.js";
    public static final String SIGN_UP_URL_SERVER = "/users/sign-up";
    public static final String LOGIN_URL = "/login.html";
    public static final String LOGIN_URL_SERVER = "/login";
    public static final String LOGIN_URL_JS = "/login.js";
    public static final String INDEX = "/index.html";
}
