DO $$
    BEGIN
        IF NOT EXISTS (SELECT 1 FROM pg_namespace WHERE nspname = 'account_service') THEN
            CREATE SCHEMA account_service;
        END IF;

        IF NOT EXISTS (SELECT 1 FROM pg_namespace WHERE nspname = 'command_service') THEN
            CREATE SCHEMA command_service;
        END IF;

        IF NOT EXISTS (SELECT 1 FROM pg_namespace WHERE nspname = 'system') THEN
            CREATE SCHEMA system;
        END IF;
    END $$;

DO $$
    BEGIN
        IF NOT EXISTS (SELECT 1 FROM pg_extension WHERE extname = 'postgis') THEN
            CREATE EXTENSION postgis SCHEMA listing_service;
        END IF;
    END $$;
