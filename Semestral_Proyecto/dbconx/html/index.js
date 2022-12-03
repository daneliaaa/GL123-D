let baseUrl = "http://localhost:8080";
let paises = [];
let registros = [];
let descripciones = [];
let acercas = [];
let logins = [];

function ObtenerPais() {
    fetch(baseUrl + '/paises/all').then(Response => {
      Response.json().then(json => {
        paises = json;
        ImprimirPaises();
      });
    });
  }

function ImprimirPaises() {
  let contenedor = document.getElementById("cuerpoTabla");
  contenedor.innerHTML = "";

  paises.forEach(pais => {
    contenedor.innerHTML += MapearPais(pais);
  });
}

function MapearPais(pais) {
  return `<tr>
  <td>
    <button class='btn btn-danger btn-sm' onclick="EliminarPais(${pais.codpais})">Eliminar</button>
    <button class='btn btn-warning btn-sm' onclick="PopularDatosCampos(${pais.codpais})">Actualizar</button>
    </td>
  <td>${pais.codpais}</td>
  <td>${pais.nombre}</td>
  <td>${pais.moro}</td>
  <td>${pais.mplata}</td>
  <td>${pais.mbronce}</td>
</tr>`;
}

function EliminarPais(cod_pais) {
  fetch(baseUrl + '/pais/' + cod_pais, { method: "Delete" }).then(res => {
    console.log(res);
    ObtenerPais();
  });
}

function GuardarPais() {
  let data = {
    nombre: document.getElementById("nombre").value,
    moro: document.getElementById("moro").value,
    mplata: document.getElementById("mplata").value,
    mbronce: document.getElementById("mbronce").value
  };

  fetch(baseUrl + "/pais", {
    method: "POST",
    body: JSON.stringify(data),
    headers: {
      "Content-type": 'application/json; charset=UTF-8'
    }
  }).then(res => {
    ObtenerPais();
  });
}

function PopularDatosCampos(codpais) {
  let pais = paises.filter(p => { return p.codpais == codpais })[0];

  document.getElementById('nombre').value = pais.nombre;
  document.getElementById('moro').value = pais.moro;
  document.getElementById('mplata').value = pais.mplata;
  document.getElementById('mbronce').value = pais.mbronce;
  document.getElementById('codpais').value = pais.codpais;

}

function ActualizarPais() {
  let data = {
    nombre: document.getElementById("nombre").value,
    moro: document.getElementById("moro").value,
    mplata: document.getElementById("mplata").value,
    mbronce: document.getElementById("mbronce").value,
    codpais: document.getElementById('codpais').value
  };

  fetch(baseUrl + "/pais", {
    method: "PUT",
    body: JSON.stringify(data),
    headers: {
      "Content-type": 'application/json; charset=UTF-8'
    }
  }).then(res => {
    ObtenerPais();
  });
}

/**Para la Descripcion */

function obtenerDescripcion() {
  fetch(baseUrl + '/descripciones/all').then(Response => {
    Response.json().then(json => {
      descripciones = json;
      ImprimirDescripciones();
    });
  });
}

function ImprimirDescripciones() {
let contenedor = document.getElementById("cuerpoTabla");
contenedor.innerHTML = "";

descripciones.forEach(descripcion => {
  contenedor.innerHTML += MapearDescripcion(descripcion);
});
}

function MapearDescripcion(descripcion) {
return `<tr>
<td>
  <button class='btn btn-danger btn-sm' onclick="EliminarDescripcion(${descripcion.cod_desc})">Eliminar</button>
  <button class='btn btn-warning btn-sm' onclick="PopularDatosCamposDesc(${descripcion.cod_desc})">Actualizar</button>
  </td>
<td>${descripcion.cod_desc}</td>
<td>${descripcion.titulo}</td>
<td>${descripcion.imagen}</td>
<td>${descripcion.descripcion}</td>
</tr>`;
}
/*
function EliminarDescripcion(cod_desc) {
fetch(baseUrl + '/descripcion/' + cod_desc, { method: "Delete" }).then(res => {
  console.log(res);
  obtenerDescripcion();
});
}

function GuardarDescripcion() {
let data = {
  titulo: document.getElementById("titulo").value,
  imagen: document.getElementById("imagen").value,
  descripcion: document.getElementById("descripcion").value
};

fetch(baseUrl + "/descripcion", {
  method: "POST",
  body: JSON.stringify(data),
  headers: {
    "Content-type": 'application/json; charset=UTF-8'
  }
}).then(res => {
  obtenerDescripcion();
});
}
/*
function PopularDatosCamposDesc(cod_desc) {
let descripcion = descripciones.filter(d => { return d.cod_desc == cod_desc })[0];

document.getElementById('titulo').value = descripcion.titulo;
document.getElementById('imagen').value = descripcion.imagen;
document.getElementById('descripcion').value = descripcion.descripcion;

}

function ActualizarDescripcion() {
let data = {
  titulo: document.getElementById("titulo").value,
  imagen: document.getElementById("imagen").value,
  descripcion: document.getElementById("descripcion").value
};

fetch(baseUrl + "/descripcion", {
  method: "PUT",
  body: JSON.stringify(data),
  headers: {
    "Content-type": 'application/json; charset=UTF-8'
  }
}).then(res => {
  obtenerDescripcion();
});
}*/

/**registrooooo */

function obtenerRegistros() {
  fetch(baseUrl + '/registros/all').then(Response => {
    Response.json().then(json => {
      registros = json;
      ImprimirRegistros();
    });
  });
}

function ImprimirRegistros() {
let contenedor = document.getElementById("cuerpoTabla");
contenedor.innerHTML = "";

registros.forEach(registro => {
  contenedor.innerHTML += MapearRegistro(registro);
});
}

function MapearRegistro(registro) {
return `<tr>
<td>
  <button class='btn btn-danger btn-sm' onclick="EliminarDescripcion(${registro.correo})">Eliminar</button>
  <button class='btn btn-warning btn-sm' onclick="PopularDatosCamposRegis(${registro.correo})">Actualizar</button>
  </td>
<td>${registro.correo}</td>
<td>${registro.nombre}</td>
<td>${registro.contraseña}</td>
</tr>`;
}

function EliminarRegistro(correo) {
  fetch(baseUrl + '/registro/' + correo, { method: "Delete" }).then(res => {
    console.log(res);
    obtenerRegistros();
  });
}

function GuardarRegistro() {
  let data = {
    correo: document.getElementById("correo").value,
    nombre: document.getElementById("nombre").value,
    contraseña: document.getElementById("contraseña").value
  };

  fetch(baseUrl + "/registro", {
    method: "POST",
    body: JSON.stringify(data),
    headers: {
      "Content-type": 'application/json; charset=UTF-8'
    }
  }).then(res => {
    obtenerRegistros();
  });
}

function PopularDatosCamposRegis(correo) {
  let registro = registros.filter(r => { return r.correo == correo })[0];

  document.getElementById('correo').value = registro.correo;
  document.getElementById('nombre').value = registro.nombre;
  document.getElementById('contraseña').value = registro.contraseña;

}

function ActualizarPais() {
  let data = {
    correo: document.getElementById("correo").value,
    nombre: document.getElementById("nombre").value,
    contraseña: document.getElementById("contraseña").value
  };

  fetch(baseUrl + "/registo", {
    method: "PUT",
    body: JSON.stringify(data),
    headers: {
      "Content-type": 'application/json; charset=UTF-8'
    }
  }).then(res => {
    obtenerRegistros();
  });
}

/**acercaaaaaaa */

function obtenerAcerca() {
  fetch(baseUrl + '/acercas/all').then(Response => {
    Response.json().then(json => {
      acercas = json;
      ImprimirAcercas();
    });
  });
}

function ImprimirAcercas() {
let contenedor = document.getElementById("cuerpoTabla");
contenedor.innerHTML = "";

acercas.forEach(acerca => {
  contenedor.innerHTML += MapearAcerca(acerca);
});
}

function MapearAcerca(acerca) {
return `<tr>
<td>
  <button class='btn btn-danger btn-sm' onclick="EliminarAcerca(${acerca.cod_acer})">Eliminar</button>
  <button class='btn btn-warning btn-sm' onclick="PopularDatosCamposAcer(${acerca.cod_acer})">Actualizar</button>
  </td>
<td>${acerca.cod_acer}</td>
<td>${acerca.imagen}</td>
<td>${acerca.acerca}</td>
</tr>`;
}

function EliminarAcerca(cod_acer) {
  fetch(baseUrl + '/acerca/' + cod_acer, { method: "Delete" }).then(res => {
    console.log(res);
    obtenerAcerca();
  });
}

function GuardarAcerca() {
  let data = {
    imagen: document.getElementById("imagen").value,
    acerca: document.getElementById("acerca").value
  };

  fetch(baseUrl + "/acerca", {
    method: "POST",
    body: JSON.stringify(data),
    headers: {
      "Content-type": 'application/json; charset=UTF-8'
    }
  }).then(res => {
    obtenerAcerca();
  });
}

function PopularDatosCamposAcer(cod_acer) {
  let acerca = acercas.filter(a => { return a.cod_acer == cod_acer })[0];

  document.getElementById('imagen').value = acerca.imagen;
  document.getElementById('acerca').value = acerca.acerca;
  document.getElementById('cod_acer').value = acerca.cod_acer;

}

function ActualizarAcerca() {
  let data = {
    imagen: document.getElementById("imagen").value,
    acerca: document.getElementById("acerca").value,
    cod_acer: document.getElementById("cod_acer").value
  };

  fetch(baseUrl + "/acerca", {
    method: "PUT",
    body: JSON.stringify(data),
    headers: {
      "Content-type": 'application/json; charset=UTF-8'
    }
  }).then(res => {
    obtenerAcerca();
  });
}

/**loghgigfigigigi */

function obtenerLogin() {
  fetch(baseUrl + '/logins/all').then(Response => {
    Response.json().then(json => {
      logins = json;
      ImprimirLogins();
    });
  });
}

function ImprimirLogins() {
let contenedor = document.getElementById("cuerpoTabla");
contenedor.innerHTML = "";

logins.forEach(login => {
  contenedor.innerHTML += MapearLogin(login);
});
}

function MapearLogin(login) {
return `<tr>
<td>
  <button class='btn btn-danger btn-sm' onclick="EliminarAcerca(${login.cod_log})">Eliminar</button>
  <button class='btn btn-warning btn-sm' onclick="PopularDatosCamposAcer(${login.cod_log})">Actualizar</button>
  </td>
<td>${login.cod_log}</td>
<td>${login.correo}</td>
<td>${login.contraseña}</td>
</tr>`;
}

function EliminarLogin(cod_log) {
  fetch(baseUrl + '/login/' + cod_log, { method: "Delete" }).then(res => {
    console.log(res);
    obtenerLogin();
  });
}

function GuardarLogin() {
  let data = {
    correo: document.getElementById("correo").value,
    contraseña: document.getElementById("contraseña").value
  };

  fetch(baseUrl + "/login", {
    method: "POST",
    body: JSON.stringify(data),
    headers: {
      "Content-type": 'application/json; charset=UTF-8'
    }
  }).then(res => {
    obtenerLogin();
  });
}

function PopularDatosCamposLog(cod_log) {
  let login = logins.filter(l => { return l.cod_log == cod_log })[0];

  document.getElementById('correo').value = login.correo;
  document.getElementById('contraseña').value = login.contraseña;
  document.getElementById('cod_log').value = login.cod_log;

}

function ActualizarLogin() {
  let data = {
    correo: document.getElementById("correo").value,
    contraseña: document.getElementById("contraseña").value,
    cod_log: document.getElementById("cod_log").value
  };

  fetch(baseUrl + "/login", {
    method: "PUT",
    body: JSON.stringify(data),
    headers: {
      "Content-type": 'application/json; charset=UTF-8'
    }
  }).then(res => {
    obtenerLogin();
  });
}