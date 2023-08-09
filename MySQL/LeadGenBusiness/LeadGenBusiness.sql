/*1*/
SELECT SUM(amount)
FROM billing 
WHERE charged_datetime >= '2012/03/01' AND charged_datetime <= '2012/03/31';
/*2*/
SELECT clients.client_id, SUM(billing.amount) AS total_recaudado
FROM clients
JOIN billing ON clients.client_id = billing.client_id
WHERE clients.client_id = 2;
/*3*/
SELECT clients.client_id, sites.domain_name
FROM clients
JOIN sites ON clients.client_id = sites.client_id
WHERE clients.client_id = 10;
/*4*/
SELECT client_id, COUNT(MONTHNAME(created_datetime)) AS CANTIDAD, MONTHNAME(created_datetime)
FROM sites
WHERE client_id = 1
GROUP BY site_id;
/*5*/
SELECT sites.client_id, sites.domain_name,COUNT(leads.leads_id) AS cantidad_leads
FROM sites 
JOIN leads ON sites.site_id = leads.site_id
WHERE leads.registered_datetime>= '2011/01/01' AND leads.registered_datetime <='2011/02/15'
GROUP BY sites.site_id;
/*6*/
SELECT CONCAT(clients.first_name, ' ', clients.last_name) AS client_name, COUNT(clients.client_id) AS number_of_leads
FROM clients
JOIN sites ON clients.client_id = sites.client_id
JOIN leads ON sites.site_id = leads.site_id
WHERE leads.registered_datetime >= '2011/01/01' AND leads.registered_datetime <= '2011/12/31'
GROUP BY clients.client_id
order by client_name;
/*7*/
SELECT CONCAT(clients.first_name, ' ', clients.last_name) AS client_name,MONTHNAME(leads.registered_datetime) AS mes,COUNT(clients.client_id) AS number_of_leads
FROM clients
JOIN sites ON clients.client_id = sites.client_id
JOIN leads ON sites.site_id = leads.site_id
WHERE leads.registered_datetime >= '2011/01/01' AND leads.registered_datetime <= '2011/06/30'
GROUP BY clients.client_id, mes
ORDER BY client_name;
/*8*/
SELECT CONCAT(clients.first_name, ' ' ,clients.last_name) AS nombre_cliente, sites.domain_name AS website, COUNT(leads.site_id) AS N_leads, MAX(date_format(leads.registered_datetime, '%M %d,' ' %Y')) AS fecha
FROM clients 
JOIN sites ON clients.client_id = sites.client_id
JOIN leads ON sites.site_id = leads.site_id
WHERE leads.registered_datetime BETWEEN '2011-01-01 00:00:00' AND '2011-12-31 00:00:00'
GROUP BY nombre_cliente, website;

SELECT CONCAT(clients.first_name, ' ' ,clients.last_name) AS nombre_cliente, sites.domain_name AS website, COUNT(leads.site_id) AS N_leadsMAX, (date_format(leads.registered_datetime, '%M %d,' ' %Y')) AS fecha
FROM clients 
JOIN sites ON clients.client_id = sites.client_id
JOIN leads ON sites.site_id = leads.site_id
WHERE leads.registered_datetime BETWEEN '2011-01-01 00:00:00' AND '2012-12-31 00:00:00'
GROUP BY nombre_cliente, website;
/*9*/
SELECT CONCAT(clients.first_name, ' ',clients.last_name) AS nombre_cliente, SUM(amount) AS monto_total, MONTHNAME(billing.charged_datetime) AS mes, YEAR(billing.charged_datetime) AS año
FROM billing
JOIN clients ON billing.client_id = clients.client_id
GROUP BY nombre_cliente, mes, año;
/*10*/
SELECT CONCAT(clients.first_name, ' ',clients.last_name) AS nombre_cliente, GROUP_CONCAT(sites.domain_name SEPARATOR ' / ') AS concatenated_domains
FROM sites
JOIN clients ON clients.client_id = sites.client_id
GROUP BY nombre_cliente, clients.client_id
ORDER BY clients.client_id
