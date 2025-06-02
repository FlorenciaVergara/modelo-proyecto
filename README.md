# Proyecto base: Generación de códigos configurables

## Descripción
Este proyecto es la base para un sistema que genera **códigos únicos** asociados a registros.

El número inicial del código es **configurable mediante variables de entorno**.  
> Esta funcionalidad está pendiente de implementación.

Actualmente, el sistema está pensado para recibir el **CUIT del responsable** y, a partir de eso, generar un código único. Luego, se guarda la relación **código–CUIT** en una tabla llamada `codigo_cuit`.

## Pendientes / A definir

- [ ] Implementar la configuración del número inicial vía variables de entorno.
- [ ] Evaluar si es necesario recibir más datos además del CUIT.
- [ ] Definir si los datos se guardan en una tabla nueva (`codigo_cuit`) o si deben vincularse con tablas existentes (por ejemplo, una tabla de contribuyentes).
- [ ] Confirmar si es necesario validar el CUIT o si asumimos que ya llega validado.


## Endpoints

- `POST /api/registros` → Genera un nuevo registro con un código único.
- `GET /api/registros/codigo/{codigo}` → Busca por el código el cuit del responsable.
- `GET /api/registros/cuit/{cuit}` → Busca por el cuit del responsable el coódigo asociado.  

## Consultas:

- Un CUIT puede tener varios codigos vinculados?
- El CUIT Debe cumplir alguna validacion extra?
- Como recibimos el dato? (Ej: "30-23446756-1" / "CUIT:30849574853"...)
- Tablas a generar o consultar
- Necesitamos recibir algun dato mas antes de generar el codigo? 
