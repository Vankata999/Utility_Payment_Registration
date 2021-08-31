insert into up_merchants(merchant_id,category_id,merchant_name,merchant_desc,list_order)
values ('0000040','1','ЧЕЗ Електро България АД','електроснабдяване','7');

insert into up_merchant_categories(category_id,categoty_name,category_type,categolory_desc,list_order)
values ('1','Електроенергия - плащане на сметки','ELECTRICITY','Чрез ePay.bg могат да се плащат сметки на битови и стопански клиенти към ЧЕЗ за град София'' ||
 '' и областите Благоевград, Кюстендил, Перник и София област, Плевен, Ловеч, Враца, Видин и Монтана.'' ||
 '' Изисквана информация в ePay.bg - 12-цифрен клиентски номер. Срок за плащане чрез ePay.bg - до погасяване на задължението.'' ||
 '' Срокът за безлихвено плащане е отбелязан във фактурата от ЧЕЗ за съответния клиентски номер.','7');

 insert into up_merchants(merchant_id,category_id,merchant_name,merchant_desc,list_order)
values ('0000047','1','Енерго-Про Продажби АД','Електроснабдителни дружества','0');

insert into up_merchant_categories(category_id,categoty_name,category_type,categolory_desc,list_order)
values ('1','Електроенергия - плащане на сметки','ELECTRICITY','Чрез ePay.bg могат да се плащат текущи сметки към ЕНЕРГО-ПРО Продажби АД за областите Силистра, Добрич, Варна, Шумен, Разград, Русе, Търговище,' ||
 ' Горна Оряховица, Велико Търново и Габрово. Не могат да се плащат сметки на фирмени абонати, както и тези, регистрирани за плащане чрез директен дебит (разплащателен влог).' ||
 ' Изисквана информация в ePay.bg - 10-цифрен клиентски номер. Клиентският номер е отбелязан във фактурата, както и в разписката за платена сметка на каса на дружеството. Информация може да получите и на телефон 0700 800 61.' ||
  ' Срок за плащане чрез ePay.bg - до погасяване на задължението. ' ||
 'Срокът за безлихвено плащане е отбелязан във фактурата от ЕНЕРГО-ПРО за съответния клиентски номер.','0');

 insert into up_merchants(merchant_id,category_id,merchant_name,merchant_desc,list_order)
values ('0000043','1','ЕВН България Електроснабдяване ЕАД','Пренос и разпределение на електрическа енергия','2');

insert into up_merchant_categories(category_id,categoty_name,category_type,categolory_desc,list_order)
values ('1','Електроенергия - плащане на сметки','ELECTRICITY','Чрез ePay.bg могат да се плащат текущи и стари задължения на битови' ||
 ' и стопански абонати на ЕВН България Електроснабдяване ЕАД.' ||
 ' В ePay.bg се въвежда Клиентски номер (10- цифрен код) или ИТН номер (7-цифрен код), отбелязани във фактурата за плащане.' ||
 ' Може да получите допълнителна информация и на телефон на ЕВН България: 0700 1 7777.','2');


insert into up_merchants(merchant_id,category_id,merchant_name,merchant_desc,list_order)
values ('0004143','24','ЕВН Трейдинг Саут Ийст Юръп ЕАД','Електроенергия - търговци свободен пазар','0');

insert into up_merchant_categories(category_id,categoty_name,category_type,categolory_desc,list_order)
values ('24','Електроенергия - търговци свободен пазар','ELECTRICITY_F','Чрез My Fibank могат да се заплащат текущи и стари' ||
' задължения. ' ||
 'В My Fibank се въвежда Клиентски номер или ИТН номер, който може да получите на телефон 0700 1 7777.','0');

 insert into up_merchants(merchant_id,category_id,merchant_name,merchant_desc,list_order)
values ('0001655','24','АРМАКО ЕНЕРДЖИ ЕАД','Търговец на свободния пазар на електроенергия','0');

insert into up_merchant_categories(category_id,categoty_name,category_type,categolory_desc,list_order)
values ('24','Електроенергия - търговци свободен пазар','ELECTRICITY_F','Няма налична информация.','0');


insert into up_merchants(merchant_id,category_id,merchant_name,merchant_desc,list_order)
values ('0000446','24','Елпро България ООД','Доставчик на електрическа енергия','0');

insert into up_merchant_categories(category_id,categoty_name,category_type,categolory_desc,list_order)
values ('24','Електроенергия - търговци свободен пазар','ELECTRICITY_F','Доставчик на електрическа енергия за крайни клиенти на територията на Р. България.' ||
 ' Координатор на стандартна балансираща група','0');

 insert into up_merchants(merchant_id,category_id,merchant_name,merchant_desc,list_order)
values ('0000446','25','ЧЕЗ България ЕАД','Електроразпределение','0');

insert into up_merchant_categories(category_id,categoty_name,category_type,categolory_desc,list_order)
values ('25','Електроенергия - присъединяване и възстановяване','ELECTRICITY_A','Чрез ePay.bg могат да се плащат сметки на битови и стопански клиенти на отворения пазар към ЧЕЗ Разпределение ' ||
 'България АД за град София и областите Благоевград, Кюстендил, Перник и София област, Плевен, Ловеч, Враца, Видин и Монтана.' ||
  ' Изисквана информация в ePay.bg - 12-цифрен клиентски номер, започващ с 52 за стопански клиенти средно напрежение, ' ||
  'с 53 за битови клиенти, 54 стопански клиенти ниско напрежение. ' ||
   'Срок за плащане чрез ePay.bg - до погасяване на задължението. Срокът за безлихвено плащане е отбелязан във фактурата от ЧЕЗ за съответния клиентски номер.",
 ','0');

 insert into up_merchants(merchant_id,category_id,merchant_name,merchant_desc,list_order)
values ('0004043','25','Електроразпределние Юг ЕАД','Епренос и разпределение на електрическа енергия','0');

insert into up_merchant_categories(category_id,categoty_name,category_type,categolory_desc,list_order)
values ('25','Електроенергия - присъединяване и възстановяване','ELECTRICITY_A','Чрез ePay.bg може да заплащате услуги за присъединяване и възстановяване на изключени услуги.' ||
 ' Могат да се плащат  текущи и стари задължения на битови абонати. В ePay.bg се въвежда Клиентски номер или ИТН номер, който може да получите на телефон  0700 1 0007.",
    ','0');