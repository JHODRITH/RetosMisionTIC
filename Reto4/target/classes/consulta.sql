
SELECT Constructora, Fecha_Inicio, Clasificacion 
FROM 'Proyecto'
WHERE Ciudad='Armenia';

SELECT l.Nombre || ' ' || l.Primer_Apellido || ' ' || l.Segundo_Apellido AS 'Nombre Lider'
FROM Lider l

SELECT l.Nombre || ' ' || l.Primer_Apellido || ' ' || l.Segundo_Apellido AS 'Nombre Líder'
FROM Lider l
WHERE l.Ciudad_Residencia = "Paris";