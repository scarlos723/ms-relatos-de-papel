openapi-generator generate -i http://localhost:8081/v3/api-docs \
  --api-package com.rdp.ms_books_catalogue.openapi \
  --model-package com.rdp.ms_books_catalogue.openapi.model \
  --invoker-package com.rdp.ms_books_catalogue.openapi.invoker \
  --group-id com.rdp.ms_books_catalogue \
  --artifact-id openapiclient \
  --artifact-version 0.0.1-SNAPSHOT \
  --library resteasy \
  -g java \
  -o srcgenerated
