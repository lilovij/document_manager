# document_manager

Впервые столкнулся с работой с формами на Java. До этого был опыт работы с ними только на Delphi, и на нем это было намного проще, как мне показалось. 

Решил все строить на JavaFX. Создавал формы в SceneBuilder-е. 

Знаю, что в проекте много косяков и недочетов. Один из самых очевидных - обновление таблицы в потоке, так как не смог наладить передачу объектов между контроллерами и управление ими из других контроллеров. Так как приложение небольшое, то это никак не сказывается на производительности, но считаю, что решение далеко не самое оптимальное. Еще есть кнопка обновления таблицы (две стрелочки), но использовалась для отладки. Не стал убирать ее умышленно на всякий случай.

Изначально делал проект под БД, но потом, внимательно прочитав ТЗ, понял, что она туда совсем не вписывается, хоть и в дополнительных критериях указано, что будут смотреть на навыки работы с БД. В итоге решил обойтись без нее. 

Еще не нравится как сделал чтение документа из файлов. Так как хотелось, чтобы документ добавлялся в список документов, который формируется из объектов, пришлось делать такой не самый удачный парсинг полей. В качестве предотвращения ошибок парсинга, сделал обработку ошибок, и, если не удается создать объект на основе выбранного файла, то выходит сообщение об ошибке. 

Также есть много повторяющегося кода, который в теории можно было бы сократить, но не хватает опыта и понимания того, как работает JavaFX (особенно не нравится MainFormController, который, очевидно, можно сделать куда компактнее). Из-за того, что экспериментировал на ходу, проект выглядит скомканным и не очень удобен для дальнейшего расширения.

В любом случае, буду рад любой критике и советам с Вашей стороны.

