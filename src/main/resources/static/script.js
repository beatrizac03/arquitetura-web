let isProd = location.hostname !== "api.render.com";

let api_url = isProd ? "http://localhost:8080" : "https://www.api.render.com";

export async function logarUsuario(dadosLogin) {
  const requestInit = {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(dadosLogin),
  };

  const response = await fetch(`${api_url}/auth/login`, requestInit);

  if (!response.ok) {
    throw new Error("Login inválido");
  }

  const token = await response.text();

  return token;
}

export async function registrarUsuario(dadosRegistro) {
  const requestInit = {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(dadosRegistro),
  };

  const response = await fetch(`${api_url}/auth/register`, requestInit);

  if (!response.ok) {
    throw new Error("Erro ao registrar usuário");
  }

  const token = await response.text();

  return token;
}

export async function getUsuarioInfo(authToken) {
  const requestInit = {
    method: "GET",
    headers: {
      Authorization: `Bearer ${authToken}`,
    },
  };

  const response = await fetch(`${api_url}/usuario/me`, requestInit);

  if (!response.ok) {
    throw new Error("Erro ao capturar info do usuário");
  }

  const usuario = await response.json();

  return usuario;
}
