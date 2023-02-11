import { useUpdateTaxRateMutation } from "apps/administration/src/api";
import * as React from "react";
import { useParams, Navigate } from "react-router-dom";
import { useGetTaxRateByNameQuery } from "apps/administration/src/api";
import { useTranslation } from "react-i18next";
import { TaxRateChange } from "./TaxRateChange";

export const TaxRateUpdate: React.FC = () => {
  const { t } = useTranslation(["taxRates", "common"]);
  const { taxRateName } = useParams();
  const { data: taxRate } = useGetTaxRateByNameQuery(taxRateName as string);
  const [updateTaxRate] = useUpdateTaxRateMutation();

  if (!taxRate) {
    return <Navigate to="/tax-rates" />;
  }

  return (
    <TaxRateChange
      headerTitle={t("updateTaxRate")}
      submitLabel={t("update", { ns: "common" })}
      initialValues={taxRate}
      onSubmit={updateTaxRate}
    />
  );
};