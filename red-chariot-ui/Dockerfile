FROM nginx:1.21.4

ARG INFO_APP_BUILD

ENV INFO_APP_BUILD=${INFO_APP_BUILD}

COPY nginx.conf /etc/nginx/nginx.conf

# TODO
#COPY build/dev /etc/nginx/html/dev
#COPY build/stage /etc/nginx/html/stage
#COPY build/prod /etc/nginx/html/prod
