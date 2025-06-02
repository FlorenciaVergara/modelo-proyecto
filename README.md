# Proyecto base: Generación de códigos configurables

## Descripción
Este proyecto es una base para un sistema que genera códigos únicos para registros.
El número inicial del código es configurable a través de variables de entorno (FALTA RESOLVER).

## Endpoints

- `POST /api/registros` → Genera un nuevo registro con un código único.
- `GET /api/registros/codigo/{codigo}` → Busca por el código el cuit del responsable.
- `GET /api/registros/cuit/{cuit}` → Busca por el cuit del responsable el coódigo asociado.  

## Cosas a consultar/resolver:

- Un CUIT puede tener varios codigos vinculados?
- El CUIT Debe cumplir alguna validacion extra?
- Como recibimos el dato? (Ej: "30-23446756-1" / "CUIT:30849574853"...)
- Tablas a generar o consultar
- Necesitamos recibir algun dato mas antes de generar el codigo? 
